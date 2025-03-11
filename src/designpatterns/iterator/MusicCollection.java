package designpatterns.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MusicCollection {
    List<Music> musicList;
    public MusicCollection() {
        musicList = new LinkedList<Music>();
    }

    public void add(Music music) {
        musicList.add(music);
    }

    public Iterator<Music> getIterator() {
        return new MusicIterator();
    }

    private class MusicIterator implements Iterator<Music> {
        int index = 0;


        @Override
        public boolean hasNext() {
            if(musicList.size() > index) {
                return true;
            }
            return false;
        }

        @Override
        public Music next() {
            if(hasNext()) {
                Music music = musicList.get(index++);
                return music;
            }
            return null;
        }
    }
}
