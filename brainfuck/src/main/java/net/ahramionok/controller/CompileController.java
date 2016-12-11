package net.ahramionok.controller;

import net.ahramionok.interpreter.BrainFuckInterpreter;
import net.ahramionok.model.Compile;
import net.ahramionok.model.CompileResult;
import net.ahramionok.model.CompileResultBreakPoint;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kirill Achramionok
 */



@RestController
public class CompileController {


    @RequestMapping(value = "/compile", method = RequestMethod.POST)
    public CompileResult getCompileResult(@RequestBody Compile content){

        return new CompileResult(content.getDate(),
                new BrainFuckInterpreter().compile(content.getContent()).run().getOutput(),
                content.getIdProject());
    }
    @RequestMapping(value = "/compile/with-break-point", method = RequestMethod.POST)
    public CompileResultBreakPoint getCompileWithBreakPointResult(@RequestBody Compile content){
        return new CompileResultBreakPoint(content.getDate(),new BrainFuckInterpreter().compile(content.getContent()).useBreakpoint().run().getTrace(),content.getIdProject());
    }
}
