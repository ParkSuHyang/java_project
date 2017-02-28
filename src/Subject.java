    class Subject
    {
        private int code;
        private String name;
        public boolean state;

        public Subject()
        {
        }

        public Subject(int code, String name)
        {
            this.code = code;
            this.name = name;
            state = false;
        }

        public void set_code(int code)
        {
            this.code = code;
        }
        public int get_code()
        {
            return code;
        }
        public void set_name(String name)
        {
            this.name = name;
        }
        public String get_name()
        {
            return name;
        }

        public void print()
        {
            Console.WriteLine("Code : {0}, Name : {1}", code, name);
        }
    }