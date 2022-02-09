package com.mdp.test.feature.user.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mdp.test.R
import com.mdp.test.base.BaseActivity
import com.mdp.test.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getActivityBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}