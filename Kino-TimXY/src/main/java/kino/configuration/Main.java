package kino.configuration;

import kino.model.ModelFactory;

public class Main {

    public static void main(String[] args) {

        ModelFactory modelFactory = ModelFactory.getInstance();
        System.out.println(modelFactory.UserRepository().findByName("Kurt Cobain").get(0));

    }

}