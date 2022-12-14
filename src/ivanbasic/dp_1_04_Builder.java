package ivanbasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class dp_1_04_Builder implements Demonstration {
    public void demonstration() {

        // complex Object
        Generator generator = new Generator();
        List<Integer> complexObject = generator.get(14);

        // Builder, Concrete Builder
        Builder blankoBuilder = new BlankoBuilder();
        Builder bracketBuilder = new BracketBuilder();
        Builder luckyBuilder = new LuckyBuilder();
        Builder oddBuilder = new OddBuilder();

        // Director
        Director dir = new Director();

        // Director constructs an object using the Builder interface
        dir.construct(complexObject, blankoBuilder);
        dir.construct(complexObject, bracketBuilder);
        dir.construct(complexObject, luckyBuilder);
        dir.construct(complexObject, oddBuilder);


    }

}

// Director
class Director {
    // Construct
    void construct(List<Integer> complexObject, Builder builder) {
        // Product
        String product = "";

        // for all the objects in structure, builder->BuildPart()
        for (Integer ii : complexObject) {
            product += builder.buildPart(ii);
        }
        System.out.println(builder);
        System.out.println(product);
        System.out.println();
    }
}

// The builder abstraction
interface Builder {
    String buildPart(int part);
}

//Concrete builder implementation('s)
class BlankoBuilder implements Builder {
    public String buildPart(int part) {
        return part + " ";
    }
}

class BracketBuilder implements Builder {
    public String buildPart(int part) {
        return "[" + part + "]";
    }
}

class OddBuilder implements Builder {
    public String buildPart(int part) {
        if ((part % 2 == 0))
            return "+" + part;

        return "-" + part;
    }
}

class LuckyBuilder implements Builder {
    public String buildPart(int part) {
        if (part == 7)
            return "[ lucky seven! ] ";
        return part + " ";
    }
}

// complex Object
class Generator {

    List<Integer> get(int lenght) {
        List<Integer> comlpexObject = new ArrayList<Integer>();

        for (int ii = 0; ii <= lenght; ii++) {
            Random rn = new Random();
            int rnum = rn.nextInt(10) + 1;
            comlpexObject.add(rnum);
        }


        return comlpexObject;
    }
}
