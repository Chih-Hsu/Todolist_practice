package com.example.tasklist.taskInputDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tasklist.R
import com.example.tasklist.database.TaskData
import com.example.tasklist.databinding.TaskInputFragmentBinding

class TaskInputDialogFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding:TaskInputFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.task_input_fragment,container,false)



        //viewModel設定
        val taskInputViewModel = ViewModelProvider(this).get(TaskInputDialogViewModel::class.java)
        binding.taskInputViewModel = taskInputViewModel

        //lifecycle設定
//        binding.setLifecycleOwner(this)
        binding.taskInputEdittext.setOnClickListener {
            binding.doneButton.visibility = View.VISIBLE
            binding.voiceButton.visibility = View.GONE
        }

        binding.doneButton.setOnClickListener {

        //TODO 建立資料到database
            //TODO 跳轉到下個葉面
        }


        return binding.root
    }
}