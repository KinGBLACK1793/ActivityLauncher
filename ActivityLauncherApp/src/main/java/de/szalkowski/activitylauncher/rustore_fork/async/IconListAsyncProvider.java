package de.szalkowski.activitylauncher.rustore_fork.async;

import android.content.Context;

import de.szalkowski.activitylauncher.rustore_fork.ui.adapter.IconListAdapter;

public class IconListAsyncProvider extends AsyncProvider<IconListAdapter> {
    private final IconListAdapter adapter;

    public IconListAsyncProvider(Context context, Listener<IconListAdapter> listener) {
        super(context, listener, false);
        this.adapter = new IconListAdapter(context);
    }

    @Override
    protected IconListAdapter run(Updater updater) {
        adapter.resolve(updater);
        return this.adapter;
    }
}
