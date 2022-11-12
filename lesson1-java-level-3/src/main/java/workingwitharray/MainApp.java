package workingwitharray;

public class MainApp {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 3, 4};
        WorkingWithArray<Integer> workingWithArray = new WorkingWithArray(array);
        workingWithArray.replaceElementByIndex(0, 1, array);
        System.out.println(workingWithArray.convertArrayToArrayList(array));
    }
}
