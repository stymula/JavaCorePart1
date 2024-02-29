
class Person {
    String name;
    int age;
}

class MakingChanges { // It's a good and standart practice to have one class and one interface in it's own files. 
                      // So for that guy better name is utilities.personTools or any other synonim of "tools"
    
    // That kind of classes are called utility classes, all of their methods are static, they do not have a state.
    // Thus you do not need a constructor,  we usually hide it using the following trick: 
    /*
    private MakingChanges() throws InstantiationException {           
        throw new InstantiationException(String.format("Utility class %s should not be instantiated ", Class.class.getClass().getName()));
    }
    */
    
    public static void changeIdentities(Person p1, Person p2) {
        String tempName = p1.name;
        int tempAge = p1.age;

        p1.name = p2.name;
        p1.age = p2.age;

        p2.name = tempName;
        p2.age = tempAge;
    }
}
