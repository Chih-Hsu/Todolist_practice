package com.example.tasklist.firstTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tasklist.R
import com.example.tasklist.databinding.FirstTaskFragmentBinding

class FirstTaskFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FirstTaskFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.first_task_fragment,container,false)



        binding.addTaskButton.setOnClickListener {
          this.findNavController().navigate(R.id.action_firstTaskFragment_to_taskInputFragment)
        }


        return binding.root
    }

}