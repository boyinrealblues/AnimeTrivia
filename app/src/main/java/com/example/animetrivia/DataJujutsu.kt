package com.example.animetrivia

class DataJujutsu {
    fun data():List<Jujutsu> {
        var list: List<Jujutsu> = listOf(
                shuffleList(Jujutsu("Satoru Gojo", "", "", "",R.drawable.gojo1,R.drawable.gojo2 )),
                shuffleList(Jujutsu("Megumi Fushiguro ", "", "", "",R.drawable.megumi1, R.drawable.megumi2)),
                shuffleList(Jujutsu("Yuji Itadori", "", "", "",R.drawable.itadori1, R.drawable.itadori2 )),
                shuffleList(Jujutsu("Kugisaki Nobara", "", "", "",R.drawable.nobara1, R.drawable.nobara2)),
                shuffleList(Jujutsu("Zenin Maki", "", "", "",R.drawable.maki1, R.drawable.maki2)),
                shuffleList(Jujutsu("Toge Inumaki", "", "", "",R.drawable.inumaki1, R.drawable.inumaki2)),
                shuffleList(Jujutsu("Nanami Yasuri", "", "", "",R.drawable.nanami1, R.drawable.nanami2)))

        return list
    }




    fun shuffleList(jujutsu:Jujutsu):Jujutsu{
        var name=listOf<String>("Satoru Gojo","Megumi Fushiguro","Yuji Itadori","Kugisaki Nobara","Zenin Maki","Toge Inumaki","Nanami Yasuri")
        var names=name.shuffled()  //shuffled

        val arr:Array<String> =Array(3,{i->(i*1).toString()})  //array for storing values to all the options
        var cnt=0   //counter
        for(i in 0..2) {
            if (names[cnt] == jujutsu.option1)   //skip if the first option matches with the list
                cnt++
            arr[i] = names[cnt]
            cnt++ //next word
        }
            jujutsu.option2=arr[0]  //assigning values to the options
            jujutsu.option3=arr[1]
            jujutsu.option4=arr[2]
        return jujutsu
    }

}