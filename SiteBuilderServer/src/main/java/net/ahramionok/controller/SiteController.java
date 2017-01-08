package net.ahramionok.controller;

import net.ahramionok.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KIrill on 07.01.2017.
 */
@RestController
public class SiteController {
    @Autowired
    private SiteService siteService;
}
