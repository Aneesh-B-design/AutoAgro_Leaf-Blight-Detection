package exmple.com.leafblightdetection

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Process
import android.os.Process.myPid
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main3.*


class Common_Remdies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common__remdies)
       // val actionBar = supportActionBar
        //actionBar!!.title = "Remedy"
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Remedy"
        //set back button

    }

    override fun onBackPressed() {
        val alertDialogBuilder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Exit Application?")
        alertDialogBuilder
            .setMessage("Click yes to exit!")
            .setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialog, id ->
                    moveTaskToBack(true)
                    Process.killProcess(myPid())
                    System.exit(1)
                })
            .setNegativeButton("No",
                DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
        val alertDialog: android.app.AlertDialog? = alertDialogBuilder.create()
        alertDialog?.show()
    }

}
