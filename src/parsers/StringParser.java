package parsers;

import core.Node;
import core.Parser;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class StringParser implements Parser {

    private String text;
    private InputStreamReader reader;

    public StringParser(String text){
        this.text = text;
        this.reader = new InputStreamReader(new ByteArrayInputStream(text.getBytes()));
    }

    @Override
    public Node parse(){
        throw new UnsupportedOperationException();
    }

    public String getText(){
        return text;
    }

    private Node buildTree(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
