import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.recyclerviewexerciceusingmvvm.R

class MyCustomDialog: DialogFragment() {


    private var mListener: Listener? = null

    fun setListener(listener: Listener?) {
        mListener = listener
    }

    interface Listener {
        fun returnData(result : String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow();
        val view = inflater.inflate(R.layout.dialog_layout, container, false)

        val editText  = view.findViewById<EditText>(R.id.dialogEditText)
        val okButton = view.findViewById<Button>(R.id.okButton)
        val cancelButton = view.findViewById<Button>(R.id.cancelButton)

        okButton.setOnClickListener {

            mListener?.returnData(editText.text.toString())
            dismiss()
        }

        cancelButton.setOnClickListener {
            dismiss()
        }

        return view
    }





}