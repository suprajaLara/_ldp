package org.example.pointcutDeclarations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // spring aop proxy support
@ComponentScan("org.example.pointcutDeclarations") // component scan for components and "aspects"
public class DemoConfigPointcut {
}
