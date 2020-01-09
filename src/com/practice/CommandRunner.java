package com.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommandRunner {

    private static Map<String, Component> componentMap = new HashMap<>();
    private static List<Component> installedComponents = new ArrayList<>();

    public static void main(String args[]){
        try {
            Scanner scanner = new Scanner(new File("/Users/achaganti/Desktop/input.txt"));
            while (scanner.hasNextLine()) {
                    processCommand(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void processCommand(String commandInput) {
        // echo the input command to output
            echo(commandInput);
        final String[] commandWords = commandInput.split("\\s+");
        Command command = Command.valueOf(commandWords[0]);

        String componentName = null;
        switch (command){
            case DEPEND:
                componentName =commandWords[1];
                processDependencies(componentName,commandWords);
                break;
            case INSTALL:
                componentName =commandWords[1];
                installComponent(componentName);
                break;
            case REMOVE:
                componentName =commandWords[1];
                removeComponent(componentName);
                break;
            case LIST:
                printComponents();
                break;
            case END:
                break;
            default:
                System.out.println("Error in the input command line starting with"+command.toString());
        }

    }

    private static void removeComponent(String componentName) {
        Component component = getComponent(componentName);
        if (!isComponentInstalled(component)) {
            System.out.println(componentName + " is not installed");
        }
            else if (isComponentRequired(component)) {
                System.out.println("Removing " + componentName);
                installedComponents.remove(component);

                final List<Component> currentSoftwareDependencies = component.getDependentComponents();
                for (Component dependency : currentSoftwareDependencies) {
                    if (isComponentRequired(dependency)) {
                        System.out.println("Removing " + dependency.getComponentName());
                        installedComponents.remove(dependency);
                    }
                }
            } else {
                System.out.println(componentName + " is still needed");
            }
        }
    private static boolean isComponentRequired(Component component) {
        for (Component installedComponent : installedComponents) {
            final List<Component> requiredDependencies = installedComponent.getDependentComponents();
            if (requiredDependencies != null) {
                for (Component dependency : requiredDependencies) {
                    if (component.equals(dependency)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void installComponent(String componentName) {
        Component component = getComponent(componentName);
        if (isComponentInstalled(component)) {
            System.out.println(componentName + " is already installed");
            return;
        }
        List<Component> componentDependencies = componentMap.get(componentName).getDependentComponents();
        for (Component componentDependency : componentDependencies) {
            if (!isComponentInstalled(componentDependency)) {
                    installComponent(componentDependency.getComponentName());
                }
            }
            System.out.println("Installing "+componentName);
            installedComponents.add(component);
        }

    private static boolean isComponentInstalled(Component component) {
        return installedComponents.contains(component);
    }

    private static void printComponents() {
        for (Component installedComponent : installedComponents) {
            System.out.println(installedComponent.getComponentName());
        }
    }

    private static void processDependencies(String componentName, String[] commandWords) {
        for(int i =2;i<commandWords.length;i++){
            final String current = commandWords[i];
            final List<Component> recurringDependcies = getComponent(current).getDependentComponents();
            if (recurringDependcies != null && recurringDependcies.contains(getComponent(componentName))) {
                System.out.println(
                        current + " depends on " + componentName + ", ignoring command");
            } else {
                getComponent(componentName).addDependentComponent(getComponent(current));
            }
        }
    }
    private static Component getComponent(String name) {
        Component component = componentMap.get(name);
        if (component == null) {
            component = new Component();
            component.setComponentName(name);
            componentMap.put(name, component);
        }
        return component;
    }

    private static void echo(String commandInput) {
        System.out.println(commandInput);
    }

    enum Command {
        DEPEND,
        INSTALL,
        REMOVE,
        LIST,
        END;
    }
}
class Component{

    private String componentName;
    private List<Component> dependentComponents = new ArrayList<Component>();

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public List<Component> getDependentComponents() {
        return dependentComponents;
    }

    public void addDependentComponent(Component component) {
        dependentComponents.add(component);
    }
}