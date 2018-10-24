package practice;

//	Noninstantiable	utility	class
    public	class	CallPrivateConstructor	{
        //	Suppress	default	constructor	for	noninstantiability
        private	CallPrivateConstructor()
        {   new CallPrivateConstructor();
            throw	new	AssertionError();
        }

        public static void main(String[] args) {
            Bird bird = new Pelican();
            Pelican pelican = new Pelican();
            pelican.fly();
        }
	//	Remainder	omitted
    }


