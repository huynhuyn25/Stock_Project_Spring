package com.huynhuyn25.projectbanggia.quickfix.generate;

import org.apache.maven.plugin.MojoExecutionException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenarateCode {
    public static void main(String[] args) throws MojoExecutionException {
        GenerateMojo generateMojo = new GenerateMojo();
        generateMojo.execute();
    }
}
