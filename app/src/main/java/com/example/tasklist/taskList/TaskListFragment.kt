package com.example.tasklist.taskList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tasklist.R
import com.example.tasklist.databinding.TasklistFragmentBinding

class TaskListFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : TasklistFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.tasklist_fragment,container,false)



        return binding.root
    }
}