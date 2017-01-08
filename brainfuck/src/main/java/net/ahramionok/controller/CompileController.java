package net.ahramionok.controller;

import net.ahramionok.interpreter.BrainFuckInterpreter;
import net.ahramionok.model.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.List;
import java.util.*;


/**
 * @author Kirill Achramionok
 */



@RestController
public class CompileController {

    @RequestMapping(value = "/compile", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompileResult getCompileResult(@RequestBody Compile content){

        String result = new BrainFuckInterpreter().compile(content.getContent()).run().getOutput();
        System.out.println("compile start: "+result);
        return new CompileResult(content.getIdProject(),content.getDate(),result);
    }

    @RequestMapping(value = "/compile/with-break-point", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompileResultBreakPoint getCompileWithBreakPointResult(@RequestBody Compile content){
        BrainFuckInterpreter interpreter = new BrainFuckInterpreter().compile(content.getContent()).useBreakpoint().run();
        return new CompileResultBreakPoint(content.getDate(),interpreter.getTrace(),content.getIdProject());
    }

    @RequestMapping(value = "/compile/debug-project", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompileResultBreakPoint getCompileDebugResult(@RequestBody Compile content){
        LinkedList<String> list = new LinkedList<String>();
        for(int i=1; i <= content.getContent().length();i++){
            BrainFuckInterpreter intr = new BrainFuckInterpreter().compile(content.getContent().substring(0,i));
            list.add(intr.run().printMemory());
        }
        return new CompileResultBreakPoint(content.getDate(),list,content.getIdProject());
    }


    @RequestMapping(value = "/compile/change-memory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompileResultChangeMemory getCompileChangeMemoryResult(@RequestBody CompileMemory content){
        LinkedList<String> list = new LinkedList<String>();
        StringBuilder sb = new StringBuilder(content.getMemory());
        sb.deleteCharAt(sb.indexOf(">"));
        content.setMemory(sb.toString().trim());
        String items[] = content.getMemory().split(" ");
        int[] array = Arrays.stream(items).mapToInt(Integer::parseInt).toArray();
        content.setContent(content.getContent().substring(content.getContent().indexOf("$")));
        if(content.getContent().contains("]")){
            if(content.getContent().contains("[")){
                content.setContent(content.getContent().substring(content.getContent().indexOf("$")+1));
            }
            else{
                content.setContent(content.getContent().replace("$","["));
            }
        }
        for(int i = 1; i < content.getContent().length(); i++) {
            BrainFuckInterpreter intr = new BrainFuckInterpreter()
                    .compile(content.getContent().substring(0,i))
                    .withMemory(array);
            list.add(intr.run().printMemory());
            System.out.println(i);

        }
        System.out.println("send to client");

        return new CompileResultChangeMemory(content.getIdProject()," ",content.getDate(),list);
    }
}
