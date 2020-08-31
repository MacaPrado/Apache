import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import org.apache.commons.text.similarity.LevenshteinDetailedDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class LevenshteinWrapper {

    private String str;

    public LevenshteinWrapper(String str) {
        this.str = str;
    }

    public int distance(String other){
        return new LevenshteinDistance().apply(str, other);
    }

    public int inserts(String other){
        return new LevenshteinDetailedDistance().apply(str,other).getInsertCount();
    }

    public int deletes(String other){
        return new LevenshteinDetailedDistance().apply(str,other).getDeleteCount();
    }

    public int subtitutes(String other){
        return new LevenshteinDetailedDistance().apply(str,other).getSubstituteCount();
    }

    public double normalizedSimilarity(String other){
        return new NormalizedLevenshtein().similarity(str,other);
    }

}
