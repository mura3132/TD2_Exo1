package com.example.exo1

import java.io.Serializable

class Word (val title : String, val definition : String, val isVideo : Boolean, val imageId : Int, val videoId : Int,  val soundId :Int) : Serializable{
}