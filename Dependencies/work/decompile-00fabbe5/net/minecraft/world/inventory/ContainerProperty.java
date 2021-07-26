package net.minecraft.world.inventory;

public abstract class ContainerProperty {

    private int prevValue;

    public ContainerProperty() {}

    public static ContainerProperty a(final IContainerProperties icontainerproperties, final int i) {
        return new ContainerProperty() {
            @Override
            public int get() {
                return icontainerproperties.getProperty(i);
            }

            @Override
            public void set(int j) {
                icontainerproperties.setProperty(i, j);
            }
        };
    }

    public static ContainerProperty a(final int[] aint, final int i) {
        return new ContainerProperty() {
            @Override
            public int get() {
                return aint[i];
            }

            @Override
            public void set(int j) {
                aint[i] = j;
            }
        };
    }

    public static ContainerProperty a() {
        return new ContainerProperty() {
            private int value;

            @Override
            public int get() {
                return this.value;
            }

            @Override
            public void set(int i) {
                this.value = i;
            }
        };
    }

    public abstract int get();

    public abstract void set(int i);

    public boolean c() {
        int i = this.get();
        boolean flag = i != this.prevValue;

        this.prevValue = i;
        return flag;
    }
}
