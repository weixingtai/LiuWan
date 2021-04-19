package com.suromo.liuwan.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.suromo.liuwan.R
import com.suromo.liuwan.databinding.FragmentUserBinding
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.text.observe(viewLifecycleOwner, Observer {
            tvUser.text = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}