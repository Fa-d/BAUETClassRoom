package go.faddy.com.agin2.Models;

import java.util.List;

public class RetrivingImageUrls {
    private List<String> strings;

    public RetrivingImageUrls() {

    }

    public RetrivingImageUrls(List<String> strings) {
        this.strings = strings;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
