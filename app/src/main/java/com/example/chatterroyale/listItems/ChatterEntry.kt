package com.example.chatterroyale.listItems

import java.util.*

class ChatterEntry {

    //VARIABLE PROPERTIES
    var vp: Int = 0                                 //VPs - Value points are used to determine when an entry is eliminated during the reduction phase
    var evp: Int = 0                                //EVPs - Effective value points are used to determine the cumulative votes an entry has received
    var alive: Boolean = true                       //Flag determines if an entry is still alive in the current round
    var upvotes: Int = 0
    var downvotes: Int = 0
    var entryPost: String = ""                      //The text post submitted by the user
    var postChars: Int = 0                          //Count the number of characters in a post, including spaces
    var timeAlive: Long = 0

    //IMMUTABLE PROPERTIES DEFINED AT CREATION
    val sTime: Date? = null                         //Submission time
    val user: String? = ""                          //The user who submitted the entry
    val roundID: String? = ""                       //The unique round ID the entry was submitted to
    val stage: Int = 1                              //The stage the entry was submitted

    //IMMUTABLE PROPERTIES DEFINED AT ELIMINATION
    var eTime: Date? = null                         //Elimination time
    var entryRank: Int? = 0

    init{
       postChars = entryPost.length
    }

    //METHODS - GETTERS AND SETTERS ARE OPTIONAL
}