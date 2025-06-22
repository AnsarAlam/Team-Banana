package com.heritagegame;
import java.util.List;
import com.heritagegame.Question;  // Make sure this import is here

public class Monument {
    private String name;
    private String backgroundImage;  // file path or URL to background image
    private String guideImage;       // file path or URL to guide (sprite) image
    private List<String> descriptions;  // list of fact strings about the monument
    private List<Question> questions;   // list of quiz questions for this monument

    public Monument(String name, String backgroundImage, String guideImage, 
                    List<String> descriptions, List<Question> questions) {
        this.name = name;
        this.backgroundImage = backgroundImage;
        this.guideImage = guideImage;
        this.descriptions = descriptions;
        this.questions = questions;
    }

    // Getter methods for each field
    public String getName() { return name; }
    public String getBackgroundImage() { return backgroundImage; }
    public String getGuideImage() { return guideImage; }
    public List<String> getDescriptions() { return descriptions; }
    public List<Question> getQuestions() { return questions; }
}
