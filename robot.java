// https://careercup.com/question?id=4902310128910336
public class Room {

    Robot robot;

    //......


    //x, y is the current location of the robot
    //from is the last step taken
    //map<x, set<y>> marks the places visited
    public int getArea(int x, int y, int from, Map<Integer, Set<Integer>> room) {

        if(room.containsKey(x) && room.get(x).contains(y)) { //if this place was visited

            robot.move(moveBack(from));        //turn robot back

            return 0;              //add 0 to total area

        }


        //mark current place visited
        if(!room.containsKey(x)) room.put(x, new HashSet<>());
        room.get(x).add(y);

        int area = 1;

        if(from != 0 && robot.move(moveBack(0))) {//if robot was not moved to current place from below, move robot down

            area += getArea(x, y - 1, 0, room);

        }


        if(from != 1 && robot.move(moveBack(1))) {//if robot didn't come from the right, move it to the right

            area += getArea(x + 1, y, 1, room);

        }

        if(from != 2 && robot.move(moveBack(2))) { //if robot didn't come from above, move it up

            area += getArea(x, y + 1, 2, room);

        }

        if(from != 3 && robot.move(moveBack(3))) { //if robot didn't come from the left, move it to the left

            area += getArea(x - 1, y, 2, room);

        }

        //after counting the areas around the current location, walk robot back to where it was from
        robot.move(moveBack(from));

        return area;
    }


    private int moveBack(int from) {

        if(from == 0) return 2;
        if(from == 1) return 3;
        if(from == 2) return 0;
        return 1;

    }


}
