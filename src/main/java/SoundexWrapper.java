import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Soundex;

public class SoundexWrapper {

    private String str;

    public SoundexWrapper(String str) {
        this.str = str;
    }

    public double distance(String other) throws EncoderException {
        double size = new Soundex().soundex(str).length();
        return new Soundex().difference(str,other)/size;
    }
}
