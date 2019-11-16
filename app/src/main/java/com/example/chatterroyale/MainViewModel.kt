package com.example.chatterroyale

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatterroyale.listItems.ChatterEntry
import com.google.firebase.firestore.FirebaseFirestore

//ViewModel for storing data that should be available to all fragments
//Primarily will be used for user data
class MainViewModel:ViewModel() {
    private val TAG = MainViewModel::class.simpleName
    private var firestoreDB: FirebaseFirestore? = FirebaseFirestore.getInstance()

    var stage: MutableLiveData<Double> = MutableLiveData()

    //TODO: Use LiveData
    fun watchCurrentStage() : LiveData<Double> {

        //Get the current stage from the master/today doc
        var todayRef = firestoreDB?.collection("master")?.document("today")
        todayRef?.addSnapshotListener{snapshot,e->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                stage.postValue(snapshot.getDouble("stage") as Double)
            } else {
                Log.d(TAG, "Current data: null")
            }
        }
        return stage
    }
}