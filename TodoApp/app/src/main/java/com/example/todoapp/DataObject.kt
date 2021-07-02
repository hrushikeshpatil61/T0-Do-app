package com.example.todoapp

object DataObject {
    var listdata = mutableListOf<Cardinfo>()

    fun setData(title: String,priority: String){
        listdata.add(Cardinfo(title,priority))
    }

    fun getAllData():List<Cardinfo>{
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }
    fun getData(pos:Int): Cardinfo {
        return listdata[pos]
    }
    fun deleteData(pos:Int){
        listdata.removeAt(pos)
    }
    fun updateData(pos:Int, title:String,priority:String){
        listdata[pos].title = title
        listdata[pos].priority= priority

    }
}