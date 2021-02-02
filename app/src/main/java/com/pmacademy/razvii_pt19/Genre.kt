package com.pmacademy.razvii_pt19

enum class Genre(var id: Int) {
    Animation(3131), Action(3132), Comedy(3133), Drama(3134), Horror(3135);

    companion object {
        fun fromId(id: Int): Genre {
            for (f in values())
                if (f.id == id) return f
            throw java.lang.IllegalArgumentException()
        }
    }
}
