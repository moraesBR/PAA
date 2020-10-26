package misc

inline operator fun <T> T.invoke(dummy: () -> Unit): T {
    dummy()
    return this
}