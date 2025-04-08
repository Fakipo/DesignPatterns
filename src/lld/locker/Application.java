package lld.locker;

import java.util.*;

import static lld.locker.Application.*;

public class Application {
    public static final Boolean LOCKER_IS_OCCUPIED = true;
    public static final Boolean LOCKER_IS_NOT_OCCUPIED = false;

    public static final Boolean SUCCESSFULLY_STORED_IN_LOCKER = true;
    public static final Boolean SUCCESSFULLY_REMOVED_FROM_LOCKER = true;

    public static final Package LOCKER_PACKAGE_DEFAULT_VALUE = null;
    public static final Integer INITIAL_NO_OF_OCCUPIED_LOCKERS = 0;

    public static final LockerRoom LOCKER_ROOM_NOT_FOUND = null;

    public static void main(String[] args){
        System.out.println("Locker System Initialization\n");

        // Create City A with a LockerRoom
        City cityA = new CityA(
                List.of(new LockerRoom(
                        List.of(
                                new Locker(new Small(), LOCKER_IS_NOT_OCCUPIED, LOCKER_PACKAGE_DEFAULT_VALUE),
                                new Locker(new Small(), LOCKER_IS_NOT_OCCUPIED, LOCKER_PACKAGE_DEFAULT_VALUE),
                                new Locker(new Large(), LOCKER_IS_NOT_OCCUPIED, LOCKER_PACKAGE_DEFAULT_VALUE)
                        ),
                        List.of(new SizeAndCapacity(new Small(), 2), new SizeAndCapacity(new Large(), 1))
                ))
        );

        // Set city reference inside locker rooms
        for (LockerRoom lockerRoom : cityA.getLockerRooms()) {
            lockerRoom.setCity(cityA);
        }

        // Try storing multiple packages of different sizes
        List<Package> packages = List.of(
                new Package(1, new Small()),
                new Package(2, new Small()),
                new Package(3, new Large()),
                new Package(4, new Medium())  // should fail, no Medium lockers
        );

        for (Package pkg : packages) {
            System.out.println("\nStoring Package ID: " + pkg.getPackageId() + " of size: " + pkg.getPackageSize().getSizeName());
            LockerRoom lockerRoom = cityA.findLockerRoom(pkg);
            System.out.println("the lockerRoom we found = " + lockerRoom);
            if (lockerRoom == null) {
                System.out.println("No locker room available for this package size.");
                continue;
            }
            LockerAndLockerAvailability availability = lockerRoom.findLockerAvailability(pkg);
            if (availability.getLockerAvailability()) {
                lockerRoom.assignLocker(pkg, availability.getLocker());
                System.out.println("Stored successfully in locker room: " + lockerRoom);
            } else {
                System.out.println("No locker available for the package in the chosen locker room.");
            }
        }

        System.out.println("\nFinal locker room states:");
        for (LockerRoom lockerRoom : cityA.getLockerRooms()) {
            System.out.println("LockerRoom:");
            for (Locker locker : lockerRoom.getLockerList()) {
                System.out.println("  Locker Size: " + locker.getSize().getSizeName() + ", Occupied: " + locker.isOccupied());
            }
        }
    }

}


interface Size {
    public String getSizeName();
}

class Small implements Size{
    public String getSizeName(){
        return this.getClass().getName();
    }
}

class Medium implements Size{
    public String getSizeName(){
        return this.getClass().getName();
    }
}

class Large implements Size{
    public String getSizeName(){
        return this.getClass().getName();
    }
}

class Package{
    private int packageId;
    private Size packageSize;

    Package(int packageId,Size packageSize){
        this.packageId = packageId;
        this.packageSize = packageSize;
    }

    public int getPackageId() {
        return packageId;
    }

    public Size getPackageSize() {
        return packageSize;
    }
}

class Locker{
    Size size;
    Boolean occupied;
    Package packageInLocker;

    Locker(Size size, Boolean occupied, Package packageInLocker){
        this.packageInLocker = packageInLocker;
        this.occupied = occupied;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Boolean isOccupied() {
        return this.occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public Package getPackageInLocker() {
        return packageInLocker;
    }

    public void setPackageInLocker(Package packageInLocker) {
        this.packageInLocker = packageInLocker;
    }
}


class SizeAndCapacity{
    Size size;
    int capacity;
    int noOfOccupiedLockers;
    SizeAndCapacity(Size size, int capacity){
        this.size = size;
        this.capacity = capacity;
        this.noOfOccupiedLockers = INITIAL_NO_OF_OCCUPIED_LOCKERS;
    }

    public int getNoOfOccupiedLockers() {
        return noOfOccupiedLockers;
    }

    public void setNoOfOccupiedLockers(int noOfOccupiedLockers) {
        this.noOfOccupiedLockers = noOfOccupiedLockers;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

class LockerAndLockerAvailability{
    Boolean LockerAvailability;
    Locker locker;


    public LockerAndLockerAvailability(Boolean lockerAvailability, Locker locker) {
        LockerAvailability = lockerAvailability;
        this.locker = locker;
    }

    public Boolean getLockerAvailability() {
        return LockerAvailability;
    }

    public void setLockerAvailability(Boolean lockerAvailability) {
        LockerAvailability = lockerAvailability;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }
}


class LockerRoom{
    City city;
    List<Locker> lockerList;
    Map<String, SizeAndCapacity> sizeAndCapacityMap;
    List<SizeAndCapacity> sizeAndCapacityList;

    public List<SizeAndCapacity> getSizeAndCapacityList() {
        return sizeAndCapacityList;
    }

    public void setSizeAndCapacityList(List<SizeAndCapacity> sizeAndCapacityList) {
        this.sizeAndCapacityList = sizeAndCapacityList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        System.out.println("we are here? setting city as " + city);
        this.city = city;
    }

    public List<Locker> getLockerList() {
        return lockerList;
    }

    public void setLockerList(List<Locker> lockerList) {
        this.lockerList = lockerList;
    }

    public Map<String, SizeAndCapacity> getSizeAndCapacityMap() {
        return sizeAndCapacityMap;
    }

    public void setSizeAndCapacityMap(Map<String, SizeAndCapacity> sizeAndCapacityMap) {
        this.sizeAndCapacityMap = sizeAndCapacityMap;
    }

    public LockerRoom(List<Locker> lockerList, List<SizeAndCapacity> sizeAndCapacities){
        this.sizeAndCapacityList = new ArrayList<>();
        this.lockerList = new ArrayList<>();
        for(Locker locker : lockerList){
            this.lockerList.add(new Locker(locker.getSize(), LOCKER_IS_NOT_OCCUPIED, LOCKER_PACKAGE_DEFAULT_VALUE));
        }
        sizeAndCapacityMap = new HashMap<>();
        System.out.println(sizeAndCapacities.size());
        for(SizeAndCapacity sizeAndCapacity : sizeAndCapacities){
            this.sizeAndCapacityList.add(sizeAndCapacity);
            this.sizeAndCapacityMap.put(sizeAndCapacity.getSize().getClass().getName(), new SizeAndCapacity(sizeAndCapacity.getSize(),sizeAndCapacity.getCapacity()));
        }
    }


    public LockerAndLockerAvailability findLockerAvailability(Package packageToDeliver){
        for(Locker locker : lockerList){
            if(locker.getSize().getClass().getName().equals(packageToDeliver.getPackageSize().getClass().getName())
                && !locker.isOccupied() == LOCKER_IS_NOT_OCCUPIED
            ){
                System.out.println("Locker is Available");
                return new LockerAndLockerAvailability(LOCKER_IS_NOT_OCCUPIED, locker);
            }
        }
        System.out.println("Locker is not Available");
        return new LockerAndLockerAvailability(LOCKER_IS_OCCUPIED, null);
    }

    public Boolean assignLocker(Package packageToLock, Locker locker){
        locker.setOccupied(LOCKER_IS_OCCUPIED);
        locker.setPackageInLocker(packageToLock);
        System.out.println(this.getCity() + " city ");
        this.getCity().getLockerRoomSearchMap().get(packageToLock.getPackageSize().getClass().getName()).remove(this);
        int totalNoLockers = this.sizeAndCapacityMap.get(locker.getSize().getClass().getName()).getNoOfOccupiedLockers();
        this.sizeAndCapacityMap.get(locker.getSize().getClass().getName()).setNoOfOccupiedLockers(totalNoLockers - 1);
        this.getCity().getLockerRoomSearchMap().get(locker.getSize().getClass().getName()).offer(this);
        System.out.println("Locker is now assigned succesfully");
        return SUCCESSFULLY_STORED_IN_LOCKER;
    }

    public Boolean removeFromLocker(Package packageToRemove, Locker locker){
        locker.setOccupied(LOCKER_IS_NOT_OCCUPIED);
        locker.setPackageInLocker(null);
        int totalNoLockers = this.sizeAndCapacityMap.get(locker.getSize().getClass().getName()).getNoOfOccupiedLockers();
        this.sizeAndCapacityMap.get(locker.getSize().getClass().getName()).setNoOfOccupiedLockers(totalNoLockers + 1);
        city.getLockerRoomSearchMap().get(locker.getSize().getClass().getName()).offer(this);
        return SUCCESSFULLY_REMOVED_FROM_LOCKER;
    }
}

interface SizePriorityQueue {
    public Size getSize();
}

interface City{
    public LockerRoom findLockerRoom(Package userPackage);
    public Map<String, PriorityQueue<LockerRoom>> getLockerRoomSearchMap();
    public List<LockerRoom> getLockerRooms();
}

class CityA implements City{
    public Map<String, PriorityQueue<LockerRoom>> getLockerRoomSearchMap() {
        return lockerRoomSearchMap;
    }

    public List<LockerRoom> getLockerRooms() {
        return lockerRooms;
    }

    public void setLockerRooms(List<LockerRoom> lockerRooms) {
        this.lockerRooms = lockerRooms;
    }

    public void setLockerRoomSearchMap(Map<String, PriorityQueue<LockerRoom>> lockerRoomSearchMap) {
        this.lockerRoomSearchMap = lockerRoomSearchMap;
    }

    List<LockerRoom> lockerRooms;

    Map<String, PriorityQueue<LockerRoom>> lockerRoomSearchMap;
    public CityA(List<LockerRoom> lockerRooms){
        this.lockerRoomSearchMap = new HashMap<>();
        this.lockerRooms = new ArrayList<>();
        for(LockerRoom lockerRoom : lockerRooms){
            LockerRoom newLockerRoom = new LockerRoom(lockerRoom.getLockerList(), lockerRoom.getSizeAndCapacityList());
            this.lockerRooms.add(newLockerRoom);
            for(SizeAndCapacity sizeAndCapacity : lockerRoom.getSizeAndCapacityList()){
                lockerRoomSearchMap.putIfAbsent(sizeAndCapacity.getSize().getClass().getName(),
                        new PriorityQueue<LockerRoom>((a,b) -> {
                            return b.getSizeAndCapacityMap().get(sizeAndCapacity.getSize().getClass().getName()).getNoOfOccupiedLockers() -
                                    a.getSizeAndCapacityMap().get(sizeAndCapacity.getSize().getClass().getName()).getNoOfOccupiedLockers();
                        })
                );
                lockerRoomSearchMap.get(sizeAndCapacity.getSize().getClass().getName()).add(newLockerRoom);
            }
        }
    }

    public LockerRoom findLockerRoom(Package userPackage){
        try{
            return lockerRoomSearchMap.get(userPackage.getPackageSize().getClass().getName()).peek();
        }catch (NullPointerException exception){
            System.out.println("There is no empty LockerRoom available");
        }finally {
            return LOCKER_ROOM_NOT_FOUND;
        }
    }
}

