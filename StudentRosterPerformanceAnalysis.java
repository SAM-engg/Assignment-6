import java.util.*;

public class StudentRosterPerformanceAnalysis {
    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        int totalStudents = 50000;
        int insertions = 1000;
        int randomAccesses = 10000;


        for (int i = 1; i <= totalStudents; i++) {
            String name = "Student " + i;
            arrayList.add(name);
            linkedList.add(name);
        }

        System.out.println("✅ Added " + totalStudents + " students to both lists.\n");


        System.out.println("🔹 TASK A: Insertions at the Beginning");

        long startTime = System.nanoTime();
        for (int i = 1; i <= insertions; i++) {
            arrayList.add(0, "New Student " + i);
        }
        long endTime = System.nanoTime();
        long arrayListInsertionTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = 1; i <= insertions; i++) {
            linkedList.add(0, "New Student " + i);
        }
        endTime = System.nanoTime();
        long linkedListInsertionTime = endTime - startTime;

        System.out.println("ArrayList insertion time (at beginning): " + arrayListInsertionTime + " ns");
        System.out.println("LinkedList insertion time (at beginning): " + linkedListInsertionTime + " ns\n");

        System.out.println("🔹 TASK B: Random Access");

        Random random = new Random();
        int size = arrayList.size();

        startTime = System.nanoTime();
        for (int i = 0; i < randomAccesses; i++) {
            int index = random.nextInt(size);
            arrayList.get(index);
        }
        endTime = System.nanoTime();
        long arrayListAccessTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < randomAccesses; i++) {
            int index = random.nextInt(size);
            linkedList.get(index);
        }
        endTime = System.nanoTime();
        long linkedListAccessTime = endTime - startTime;

        System.out.println("ArrayList random access time: " + arrayListAccessTime + " ns");
        System.out.println("LinkedList random access time: " + linkedListAccessTime + " ns\n");


        System.out.println(" Performance Summary:");
        System.out.println("Insertion (beginning): ArrayList = " + arrayListInsertionTime + " ns | LinkedList = " + linkedListInsertionTime + " ns");
        System.out.println("Random Access: ArrayList = " + arrayListAccessTime + " ns | LinkedList = " + linkedListAccessTime + " ns");

        System.out.println("\n Program completed successfully!");
    }
}
