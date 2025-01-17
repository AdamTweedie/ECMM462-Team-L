import java.util.Random;

public class solver {
    public static craneSchedule solve(world world){
        //Decide the block
        Random r = new Random();
        //If the crane is not working, then generate new steps and work
        if(world.currentMove.executed == true){
            world.crane.isWorking = true;

            // Return value should be on the top of the stack and emptyMove is true or not
            int index = r.nextInt(world.nowblock.size());//The block
            int src = 0;//source id
            int tgt = 0;//target id

            craneMove newMove = new craneMove(world.crane);

            if(world.crane.horizonPosition != src){

            }
            else{

            }

            newMove.emptyMove = false;
            world.crane.load = world.nowblock.get(index);

            if(world.nowblock.get(index).position == 0){// Possibilities that 0 move to 2
                newMove.indexId = index;
                newMove.blockId = world.nowblock.get(index).id;
                newMove.sourceId = 0;
                newMove.targetId = 1;
                newMove.stepCost = stepCost(newMove.sourceId, newMove.targetId);
                newMove.timeCost = newMove.stepCost * world.property.craneMoveTime;
                newMove.stepIndex = 1;
                world.currentMove = newMove;
            }
            if(world.nowblock.get(index).position == 1){
                newMove.indexId = index;
                newMove.blockId = world.nowblock.get(index).id;
                newMove.sourceId = 1;
                newMove.targetId = 2;
                newMove.stepCost = stepCost(newMove.sourceId, newMove.targetId);
                newMove.timeCost = newMove.stepCost * world.property.craneMoveTime;
                newMove.stepIndex = 1;
                world.currentMove = newMove;
            }
            world.schedule.moves.add(newMove);
        }
        else{// Should consider time cost, default == 1
            // If reach the last step, shut it down
            if(world.currentMove.stepIndex == world.currentMove.stepCost){
                world.crane.isWorking = false;
            }
            // Else step into next step
            else{
                world.currentMove.stepIndex++;
            }
        }
        return world.schedule;
    }

    //
    public static int stepCost1(world world){
        int cost = 0;
        if(world.currentMove.sourceId == 0 && world.currentMove.targetId == 1){
            if(world.currentMove.emptyMove == true){
                cost = 1;
            }
            if(world.currentMove.emptyMove == false){
                cost = 5;
            }
        }
        if(world.currentMove.sourceId == 0 && world.currentMove.targetId == 2){
            if(world.currentMove.emptyMove == true){
                cost = 2;
            }
            if(world.currentMove.emptyMove == false){
                cost = 6;
            }
        }
        if(world.currentMove.sourceId == 1 && world.currentMove.targetId == 0){
            if(world.currentMove.emptyMove == true){
                cost = 1;
            }
            if(world.currentMove.emptyMove == false){
                cost = 5;
            }
        }
        if(world.currentMove.sourceId == 1 && world.currentMove.targetId == 2){
            if(world.currentMove.emptyMove == true){
                cost = 1;
            }
            if(world.currentMove.emptyMove == false){
                cost = 5;
            }
        }
        if(world.currentMove.sourceId == 2 && world.currentMove.targetId == 0){
            if(world.currentMove.emptyMove == true){
                cost = 2;
            }
            if(world.currentMove.emptyMove == false){
                cost = 6;
            }
        }
        if(world.currentMove.sourceId == 2 && world.currentMove.targetId == 1){
            if(world.currentMove.emptyMove == true){
                cost = 1;
            }
            if(world.currentMove.emptyMove == false){
                cost = 5;
            }
        }
        if(world.currentMove.sourceId == 0 && world.currentMove.targetId == 0) {
            if (world.currentMove.emptyMove == true) {
                cost = 0;
            }
            if (world.currentMove.emptyMove == false) {
                cost = 2;
            }
        }
        if(world.currentMove.sourceId == 1 && world.currentMove.targetId == 1) {
            if (world.currentMove.emptyMove == true) {
                cost = 0;
            }
            if (world.currentMove.emptyMove == false) {
                cost = 2;
            }
        }
        if(world.currentMove.sourceId == 2 && world.currentMove.targetId == 2) {
            if (world.currentMove.emptyMove == true) {
                cost = 0;
            }
            if (world.currentMove.emptyMove == false) {
                cost = 2;
            }
        }
        return cost;
    }

    // Count the time cost of the move
    public static int stepCost(int srcId, int tgtId){
        int step = 0;
        if(srcId == 0 && tgtId == 1){
            step = 5;
        }
        if(srcId == 0 && tgtId == 2){
            step = 6;
        }
        if(srcId == 1 && tgtId == 0){
            step = 1;
        }
        if(srcId == 1 && tgtId == 2){
            step = 5;
        }
        if(srcId == 2 && tgtId == 0){
            step = 2;
        }
        if(srcId == 2 && tgtId == 1){
            step = 1;
        }
        return step;
    }
}
