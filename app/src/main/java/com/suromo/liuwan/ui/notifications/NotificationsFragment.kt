package com.suromo.liuwan.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.suromo.liuwan.R
import com.suromo.liuwan.databinding.FragmentNotificationsBinding
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            tvNotifications.text = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}