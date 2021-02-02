package com.pmacademy.razvii_pt19

enum class Currency(var id: Int) {
    UAH(545), USD(546), EUR(547), RUB(548);

    companion object {
        fun fromId(id: Int): Currency {
            for (f in values())
                if (f.id == id) return f
            throw java.lang.IllegalArgumentException()
        }
    }
}