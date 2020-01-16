package asm;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {

        VirtualMachine vm = VirtualMachine.attach("19376");
        vm.loadAgent("D:/workspace_java/Java_Practise/ASMDemo/target/ASMDemo-1.0-SNAPSHOT-jar-with-dependencies.jar");
    }
}