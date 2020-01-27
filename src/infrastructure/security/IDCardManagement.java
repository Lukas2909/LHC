package infrastructure.security;

import java.util.Map;
import java.util.Stack;

public enum IDCardManagement {
    instance;
    private Map<Integer,IDCard> idCardHashMap;
    private Writer writer = new Writer();
    private Reader reader = new Reader();



    private Stack<IDCard> idCardStackVisitor = new Stack<IDCard>();
    private Stack<IDCard> idCardStackEmployee = new Stack<IDCard>();

    public Writer getWriter(){
        return this.writer;
    }
    public Reader getReader() {
        return reader;
    }

    // Nur ein mal aufrufen zu Initialisierung!!
    public void generateIDCards(int numberVisitor, int numberEmployee){
        for(int i = 0; i< numberVisitor; i++){
            idCardStackVisitor.add(new IDCardVisitor(Integer.toString(i+1)));
        }
        for(int i=numberVisitor; i< (numberEmployee+numberVisitor); i++){
            idCardStackEmployee.add(new IDCardEmployee(Integer.toString(i)));
        }
    }

    public IDCard getNextBlankIDCard(IDCardType idCardType){
        if(idCardType== IDCardType.Visitor){
            return idCardStackVisitor.pop();
        }
        else if(idCardType== IDCardType.Employee){
            return idCardStackEmployee.pop();
        }
        else{
            //Fall kann nicht auftreten!!
            return null;
        }

    }

    public void assignIDCard(IDCard idCard, human_ressources.Employee employee)
    {

    }

    public void lockIDCard(IDCard idCard)
    {

    }

    public void clearIDCard(IDCard idCard)
    {

    }
}
