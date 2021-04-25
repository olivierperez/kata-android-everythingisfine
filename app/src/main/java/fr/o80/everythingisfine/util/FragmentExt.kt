package fr.o80.everythingisfine.util

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.closeKeyboard() {
    (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(requireView().windowToken, 0)
}
