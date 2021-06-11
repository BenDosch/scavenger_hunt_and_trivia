package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.activities.AdminActivity
import android.app.AlertDialog
import android.content.DialogInterface



class AdminLoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Change activity when "Submit" button is clicked
        val submit = view.findViewById<Button>(R.id.btnSubmit)
        submit.setOnClickListener {
            // Takes the entered password and compares it to value. If correct launches admin
            // else it clears field and re-requests password
            val entry = view.findViewById<EditText>(R.id.editTextTextPassword).text.toString()

            if ( entry.compareTo(getString(R.string.parse_application_id)) == 0 ) {
                val intent = Intent(activity, AdminActivity::class.java)
                startActivity(intent)
            } else {
                view.findViewById<EditText>(R.id.editTextTextPassword).text.clear()
                val dialogBuilder = AlertDialog.Builder(this.activity)
                dialogBuilder.setMessage("Please re-enter your password")
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("Incorrect Password")
                // show alert dialog
                alert.show()
            }
        }
    }
}

