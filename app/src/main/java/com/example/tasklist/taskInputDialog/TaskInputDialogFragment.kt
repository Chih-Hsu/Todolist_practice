package com.example.tasklist.taskInputDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tasklist.R
import com.example.tasklist.database.TaskDataDatabase
import com.example.tasklist.databinding.TaskInputFragmentBinding

class TaskInputDialogFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding:TaskInputFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.task_input_fragment,container,false)



        //viewModel設定
        val application = requireNotNull(this.activity).application
        val database = TaskDataDatabase.getInstance(application).taskDataDao
        val viewModelFactory = TaskInputDialogViewModelFactory(database)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(TaskInputDialogViewModel::class.java)
        binding.taskInputViewModel = viewModel

        //lifecycle設定
//        binding.setLifecycleOwner(this)
        binding.taskInputEdittext.setOnClickListener{
            binding.doneButton.visibility = View.VISIBLE
            binding.voiceButton.visibility = View.GONE
        }

        binding.doneButton.setOnClickListener {
            viewModel.addNewTask(binding.taskInputEdittext.text.toString())

        }


        return binding.root
    }
}