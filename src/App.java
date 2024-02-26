public class App {

    public static boolean checkIfIsSorted(int[] sampleArray) {
        boolean isSorted = true;
        for (int i = 0; i < sampleArray.length - 1; i++) {
            if(sampleArray[i] > sampleArray[i + 1]) {
                isSorted = false;
            }
        }
        return isSorted;
    }
    public static void main(String[] args) throws Exception {
        Menu.showMenu();
    }  
}
