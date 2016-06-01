package com.sandarkin.so.q37548350;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private final ApplicationContext context;

  @Autowired
  public MainController(ApplicationContext context) {
    this.context = context;
  }

  @RequestMapping("/")
  public String[] printAllBeanNames() {
    return this.context.getBeanDefinitionNames();
  }
}
