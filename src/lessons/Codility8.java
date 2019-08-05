package lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Codility8 {
    public int solution(int[] A) {
        if (A.length == 0) return -1;
        // write your code in Java SE 8
        int leaderCount = A.length/2+1;

        List<Peer> peers = Peer.makePeerList(A);
        Collections.sort(peers);

        //1,2,3,4,4,4,6,7,7,8
        int[] leaderValueArray = new int[A.length];
        int index = 0;

        int peerSize = peers.size();
        for (int i = 0; i < peerSize-1; i++) {
            if (index == peerSize) break;
            leaderValueArray[index] = peers.get(i).getIndex();
            index ++;
            for (int j = i+1; j<peerSize; j++) {
                if (peers.get(i).getValue() != peers.get(j).getValue()) {
                    if (index < leaderCount) {
                        leaderValueArray = new int[peerSize];
                        index = 0;
                        break;
                    }

                    return peers.get(i).getIndex();
                } else {
                    leaderValueArray[index] = j;
                    index ++;
                }
            }
        }

        if (index < leaderCount-1) return -1;
        return peers.get(leaderValueArray[0]).getIndex();
    }
}

class Peer implements Comparable<Peer>{
    private int index;
    private int value;

    Peer(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public static List<Peer> makePeerList(int[] array) {
        List<Peer> peers = new ArrayList<Peer>();

        for (int i=0; i < array.length; i++) {
            peers.add(new Peer(i, array[i]));
        }

        return peers;
    }

    public int getIndex() {
        return this.index;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Peer o) {
        if (this.value > o.value)
            return 1;
        else if (this.value < o.value)
            return -1;
        return 0;
    }
}
