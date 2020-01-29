package human_ressources;

import infrastructure.security.IDCardVisitor;

public class Visitor extends Person {
    public Visitor(int id, String name, int[][] iris){
        super(id,name,iris);
    }

    public IDCardVisitor getIDCard(){
        return (IDCardVisitor)this.idCard;
    }

}
