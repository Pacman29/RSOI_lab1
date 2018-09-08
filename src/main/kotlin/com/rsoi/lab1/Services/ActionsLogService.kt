package com.rsoi.lab1.Services

import com.rsoi.lab1.Models.ActionModel
import org.springframework.stereotype.Service

@Service
class ActionsLogService{

    private val list = ArrayList<ActionModel>();

    public fun addAction(model: ActionModel) {
        list.add(model)
    }

    public fun printActions(): String {
        val result = StringBuilder();
        for(model in list)
            result.append(String.format("time: %s\taction type: %s\t param1: %f\t param2: %f\t result: %f\n",
                    model.time.toString(),model.type,model.param1,model.param2,model.res))

        return result.toString();
    }

    public fun clear() {
        list.clear();
    }
}
