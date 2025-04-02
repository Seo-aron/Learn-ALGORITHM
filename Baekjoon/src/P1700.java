import java.util.*;

public class P1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hole = sc.nextInt();
        int useCount  = sc.nextInt();
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < useCount; i++){
            queue.offer(sc.nextInt());
        }

        while (!queue.isEmpty()){
            int addDevice = queue.poll();

            // 다음 전자기기가 멀티탭에 있는 경우
            if (list.contains(addDevice)){
                continue;
            }

            // 멀티탭 구가 남은 경우
            if (list.size() < hole){
                list.add(addDevice);
                continue;
            }

            // 멀티탭에 새로운 전자기기를 사용해야할 경우
            int deleteDevice = -1;
            int lastUseIndex = -1;

            for (int usedDevice : list){
                int nextUseIndex = deviceCheck(queue, usedDevice);

                if (nextUseIndex == -1){
                    deleteDevice = usedDevice;
                    break;
                }

                if (nextUseIndex > lastUseIndex){
                    lastUseIndex = nextUseIndex;
                    deleteDevice = usedDevice;
                }
            }
            // 인덱스번호가 아닌 값 자체를 제거하기 위해 (Integer) 사용
            list.remove((Integer) deleteDevice);
            list.add(addDevice);
            count++;
        }

        System.out.println(count);
    }

    private static int deviceCheck(Queue<Integer> queue, int usedDevice) {
        int index = 1;

        for (int num : queue){
            if (num == usedDevice){
                return index;
            }
            index++;
        }
        return -1;
    }
}
