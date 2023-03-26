package com.tn.shoestore.utils

import java.util.regex.Pattern

private const val EMAIL_ADDRESS_PATTERN =
    "[a-zA-Z0-9+._%\\-]{1,256}" + "@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"

private const val PASSWORD_PATTERN =
    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}"

fun isValidEmailAddress(str: String): Boolean =
    Pattern.compile(EMAIL_ADDRESS_PATTERN).matcher(str).matches()

fun isValidPassword(password: String): Boolean =
    Pattern.compile(PASSWORD_PATTERN).matcher(password).matches()