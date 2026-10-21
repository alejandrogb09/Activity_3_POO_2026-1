package Grades;

public class Grades {
    double[] gradeList;
    
    public Grades() {
        gradeList = new double[5];
    }
    
    double calculateAvg() {
        double sum = 0;
        for (int i=0; i < gradeList.length; i++) {
            sum = sum + gradeList[i];
        }
        return (sum / gradeList.length);
    }
    
    double calculateDeviation() {
        double avg = calculateAvg();
        double sum = 0;
        for(int i=0; i < gradeList.length; i++) {
            sum += Math.pow(gradeList[i] - avg, 2);
        }
        return Math.sqrt(sum/gradeList.length);
    }
    
    double calculateShorter() {
        double shorter = gradeList[0];
        for (int i=0; i < gradeList.length; i++) {
            if(gradeList[i] < shorter) {
                shorter = gradeList[i];
            }
        }
        return shorter;
    }
    
    double calculateLarger() {
        double larger = gradeList[0];
        for (int i=0; i < gradeList.length; i++) {
            if (gradeList[i] > larger) {
                larger = gradeList[i];
            }
        }
        return larger;
    }
}
