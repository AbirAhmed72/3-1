package workshop;

        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.ArrayList;
        import java.util.List;

public class PlaintextToHtmlConverter {
    String source;
    int position;                                       //inappropriate variable name solved
    List<String> result;
    List<String> convertedLine;
    String characterToConvert;

    public String toHtml() throws Exception {
        String text = readFiles();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read() throws IOException {            //inappropriate method name solved
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }

    private String basicHtmlEncode(String source) {
        this.source = source;
        position = 0;
        result = new ArrayList<>();
        convertedLine = new ArrayList<>();
        characterToConvert = getNextCharAndAdvance();

        while (position <= this.source.length()) {
            convertChar();

            if (position >= source.length()) break;

            characterToConvert = getNextCharAndAdvance();
        }
        addANewLine();
        String finalResult = String.join("<br />", result);
        return finalResult;
    }

    private void convertChar(){                             //used method extraction
        switch (characterToConvert) {
            case "<":
                convertedLine.add("&lt;");
                break;
            case ">":
                convertedLine.add("&gt;");
                break;
            case "&":
                convertedLine.add("&amp;");
                break;
            case "\n":
                addANewLine();
                break;
            default:
                convertedLine.add(characterToConvert);;
        }
    }
    private String getNextCharAndAdvance() {                    //inappropriate method name solved
        char c = source.charAt(position);
        position += 1;
        return String.valueOf(c);
    }

    //comment smell removed
    private void addANewLine() {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private void pushACharacterToTheOutput() {
        convertedLine.add(characterToConvert);
    }
}




